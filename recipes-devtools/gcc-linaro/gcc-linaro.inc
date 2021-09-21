#
# This file was derived from the 'Hello World!' example recipe in the
# Yocto Project Development Manual.
#

SUMMARY = "Linaro toolchain"
SECTION = "examples"
LICENSE = "CLOSED"

do_configure[noexec] = "1"
do_compile[noexec] = "1"

do_install () {
	install -d ${D}/${bindir}
	install -d ${D}/${bindir}/${PN}-${PV}

	cp -R --no-dereference --preserve=mode,links -v ${WORKDIR}/${TC_NAME}/* ${D}/${bindir}/${PN}-${PV}/
}

BBCLASSEXTEND =+ "native nativesdk"
INHIBIT_SYSROOT_STRIP = "1"
