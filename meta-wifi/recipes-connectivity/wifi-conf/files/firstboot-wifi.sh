#!/bin/sh
# firstboot-wifi.sh – sadece ilk açılışta /boot/wifi.txt'i okur

if [ -f /boot/wifi.txt ]; then
    SSID=$(grep '^SSID=' /boot/wifi.txt | cut -d= -f2-)
    PSK=$( grep '^PSK='  /boot/wifi.txt | cut -d= -f2-)

    if [ -n "$SSID" ] && [ -n "$PSK" ]; then
        ### TEMİZ here-dok, hiç ek/kaçış karakteri yok ###
        cat > /etc/wpa_supplicant/wpa_supplicant-wlan0.conf <<EOF
ctrl_interface=DIR=/run/wpa_supplicant
country=TR
network={
    ssid="$SSID"
    psk="$PSK"
    key_mgmt=WPA-PSK
}
EOF
        chmod 600 /etc/wpa_supplicant/wpa_supplicant-wlan0.conf
        rm -f /boot/wifi.txt
    fi
fi

# Tek seferlik; kendini devre dışı bırak
exit 0
