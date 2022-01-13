#
# This file was derived from the 'Hello World!' example recipe in the
# Yocto Project Development Manual.
#

SUMMARY = "ARM toolchain"
SECTION = "devel"
LICENSE = "CLOSED"

TC_NAME = "gcc-arm-10.2-2020.11-x86_64-aarch64-none-elf"

SRC_URI = "https://developer.arm.com/-/media/Files/downloads/gnu-a/10.2-2020.11/binrel/${TC_NAME}.tar.xz"

SRC_URI[md5sum] = "e16953f27942e5073fe895c742583d60"

do_configure[noexec] = "1"
do_compile[noexec] = "1"

do_install () {
	install -d ${D}/${bindir}
	install -d ${D}/${bindir}/${PN}-${PV}

	cp -R --no-dereference --preserve=mode,links -v ${WORKDIR}/${TC_NAME}/* ${D}/${bindir}/${PN}-${PV}/
}

BBCLASSEXTEND =+ "native nativesdk"
INHIBIT_SYSROOT_STRIP = "1"
