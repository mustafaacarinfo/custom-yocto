# wpa-supplicant_%.bbappend  --- meta-wifi katmanında

SYSTEMD_SERVICE:${PN} += "wpa_supplicant@wlan0.service"
SYSTEMD_AUTO_ENABLE:${PN} = "enable"
