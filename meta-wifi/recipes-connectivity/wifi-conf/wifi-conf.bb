SUMMARY          = "Pre-seeded wpa_supplicant config for wlan0 (+ /boot/wifi.txt import)"
LICENSE          = "CLOSED"
SRC_URI          = "file://wpa_supplicant.conf \
                   file://firstboot-wifi.sh \
                   file://firstboot-wifi.service"

PR               = "r3"

inherit allarch systemd

S = "${WORKDIR}"

do_install() {
    install -Dm0600 ${S}/wpa_supplicant.conf \
        ${D}${sysconfdir}/wpa_supplicant/wpa_supplicant-wlan0.conf

    install -Dm0755 ${WORKDIR}/firstboot-wifi.sh \
        ${D}/usr/bin/firstboot-wifi.sh

    install -Dm0644 ${WORKDIR}/firstboot-wifi.service \
        ${D}${systemd_system_unitdir}/firstboot-wifi.service
}

FILES_${PN} = "${sysconfdir}/wpa_supplicant/* \
               /usr/bin/firstboot-wifi.sh \
               ${systemd_system_unitdir}/firstboot-wifi.service"

SYSTEMD_SERVICE_${PN} = "firstboot-wifi.service"
SYSTEMD_AUTO_ENABLE   = "enable"
