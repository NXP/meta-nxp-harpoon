#
# This file was derived from the 'Hello World!' example recipe in the
# Yocto Project Development Manual.
#

SUMMARY = "ARM toolchain"
SECTION = "devel"
LICENSE = "CLOSED"

TC_NAME = "gcc-arm-10.3-2021.07-x86_64-aarch64-none-elf"

SRC_URI = "https://developer.arm.com/-/media/Files/downloads/gnu-a/10.3-2021.07/binrel/${TC_NAME}.tar.xz"

SRC_URI[md5sum] = "0b3df9b763899d66a00b21a51a5b27b1"

do_configure[noexec] = "1"
do_compile[noexec] = "1"

do_install () {
	install -d ${D}/${bindir}
	install -d ${D}/${bindir}/${PN}-${PV}

	cp -R --no-dereference --preserve=mode,links -v ${WORKDIR}/${TC_NAME}/* ${D}/${bindir}/${PN}-${PV}/
}

BBCLASSEXTEND =+ "native nativesdk"
INHIBIT_SYSROOT_STRIP = "1"
