FILESEXTRAPATHS:prepend := "${THISDIR}/files:"
# Özgün dosyayı ez: önce paketin koyduğu boş conf’u sil, sonra bizimkini kopyala
do_install:append() {
    rm -f ${D}${sysconfdir}/wpa_supplicant.conf
    install -m0600 ${WORKDIR}/wpa_supplicant.conf \
           ${D}${sysconfdir}/wpa_supplicant.conf
}
