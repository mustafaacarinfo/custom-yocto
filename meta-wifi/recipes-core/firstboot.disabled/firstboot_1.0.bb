SUMMARY = "Import Wi-Fi creds from /boot/wifi.txt on first boot"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

# Disable native/nativesdk variants
BBCLASSEXTEND = ""

SRC_URI = "file://99_wifi_import.sh"
S = "${WORKDIR}"

do_install() {
    install -Dm0755 ${WORKDIR}/99_wifi_import.sh \
        ${D}${sysconfdir}/profile.d/99_wifi_import.sh
}

FILES_${PN} = "${sysconfdir}/profile.d/99_wifi_import.sh"
PACKAGE_ARCH = "all"
