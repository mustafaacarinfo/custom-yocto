SUMMARY = "BusyBox-init script for Wi-Fi autoconnect"
LICENSE = "CLOSED"
SRC_URI = "file://S50wifi"

do_install() {
    install -Dm0755 ${WORKDIR}/S50wifi ${D}${sysconfdir}/init.d/S50wifi
}
FILES:${PN} = "${sysconfdir}/init.d/S50wifi"
