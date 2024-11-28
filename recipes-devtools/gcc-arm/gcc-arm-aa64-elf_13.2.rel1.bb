#
# This file was derived from the 'Hello World!' example recipe in the
# Yocto Project Development Manual.
#

SUMMARY = "ARM toolchain"
SECTION = "devel"
LICENSE = "CLOSED"

TC_NAME = "arm-gnu-toolchain-${PV}-x86_64-aarch64-none-elf"

SRC_URI = "https://developer.arm.com/-/media/Files/downloads/gnu/${PV}/binrel/${TC_NAME}.tar.xz"

SRC_URI[md5sum] = "b4aa2d1c2d9c857e194e28a2a8271321"

do_configure[noexec] = "1"
do_compile[noexec] = "1"

do_install () {
	install -d ${D}${bindir}
	install -d ${D}${bindir}/${PN}-${PV}

	# Unlike TC_NAME, the toolchain string name after decompress contains an uppercase Rel1
	cp -R --no-dereference --preserve=mode,links -v ${WORKDIR}/arm-gnu-toolchain-13.2.Rel1-x86_64-aarch64-none-elf/* ${D}${bindir}/${PN}-${PV}/
}

BBCLASSEXTEND =+ "native nativesdk"
INHIBIT_SYSROOT_STRIP = "1"
