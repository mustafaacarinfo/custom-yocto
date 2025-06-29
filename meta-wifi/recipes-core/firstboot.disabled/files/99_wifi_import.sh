#!/bin/sh
WIFI_CFG="/boot/wifi.txt"
DST="/etc/wpa_supplicant/wpa_supplicant-wlan0.conf"

[ -f "$WIFI_CFG" ] || exit 0          # Dosya yok → çık
ssid=$(awk -F= '/^SSID=/{print $2}' "$WIFI_CFG")
psk=$(awk  -F= '/^PSK=/{print $2}'  "$WIFI_CFG")
[ -z "$ssid" ] || [ -z "$psk" ] && exit 0   # Boşsa çık

cat > "$DST" <<EOF
ctrl_interface=DIR=/run/wpa_supplicant
country=TR
network={
    ssid="$ssid"
    psk="$psk"
    key_mgmt=WPA-PSK
}
EOF

chmod 600 "$DST"
rm -f "$WIFI_CFG"                     # Tek kullanımlık
systemctl restart wpa_supplicant@wlan0 2>/dev/null || true
