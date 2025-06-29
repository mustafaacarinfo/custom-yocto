SUMMARY = "networkd config for wlan0"
LICENSE = "CLOSED"
SRC_URI  = "file://wlan0.network"

do_install() {
    install -Dm0644 ${WORKDIR}/wlan0.network \
        ${D}${sysconfdir}/systemd/network/wlan0.network
}
FILES:${PN} = "${sysconfdir}/systemd/network/wlan0.network"
