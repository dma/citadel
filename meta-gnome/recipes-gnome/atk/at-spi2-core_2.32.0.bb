SUMMARY = "Assistive Technology Service Provider Interface (dbus core)"
HOMEPAGE = "https://wiki.linuxfoundation.org/accessibility/d-bus"
LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=e9f288ba982d60518f375b5898283886"

MAJ_VER = "${@oe.utils.trim_version("${PV}", 2)}"

SRC_URI = "${GNOME_MIRROR}/${BPN}/${MAJ_VER}/${BPN}-${PV}.tar.xz \
           "

SRC_URI[md5sum] = "57269004541646c4c5cf0bcb7c99bb5b"
SRC_URI[sha256sum] = "43a435d213f8d4b55e8ac83a46ae976948dc511bb4a515b69637cb36cf0e7220"

DEPENDS = "dbus glib-2.0 virtual/libx11 libxi libxtst"

inherit meson gtk-doc gettext systemd pkgconfig distro_features_check upstream-version-is-even gobject-introspection
# depends on virtual/libx11
REQUIRED_DISTRO_FEATURES = "x11"

EXTRA_OEMESON = " -Dsystemd_user_dir=${systemd_user_unitdir} \
                  -Ddbus_daemon=${bindir}/dbus-daemon"

GTKDOC_ENABLE_FLAG = "-Denable_docs=true"
GTKDOC_DISABLE_FLAG = "-Denable_docs=false"

GI_ENABLE_FLAG = "-Denable-introspection=yes"
GI_DISABLE_FLAG = "-Denable-introspection=no"

EXTRA_OEMESON_append_class-target = " ${@bb.utils.contains('GI_DATA_ENABLED', 'True', '${GI_ENABLE_FLAG}', \
                                                                                       '${GI_DISABLE_FLAG}', d)} "

EXTRA_OEMESON_append_class-target = " ${@bb.utils.contains('GTKDOC_ENABLED', 'True', '${GTKDOC_ENABLE_FLAG}', \
                                                                                     '${GTKDOC_DISABLE_FLAG}', d)} "

FILES_${PN} += "${datadir}/dbus-1/services/*.service \
                ${datadir}/dbus-1/accessibility-services/*.service \
                ${datadir}/defaults/at-spi2 \
                ${systemd_user_unitdir}/at-spi-dbus-bus.service \
                "
BBCLASSEXTEND = "native"
