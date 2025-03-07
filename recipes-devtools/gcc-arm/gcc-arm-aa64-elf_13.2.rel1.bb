# Copyright 2021-2022, 2024-2025 NXP

SUMMARY = "ARM toolchain"
SECTION = "devel"
LICENSE = "GPL-3.0-with-GCC-exception & GPL-3.0-only"

TC_NAME = "arm-gnu-toolchain-${PV}-x86_64-aarch64-none-elf"

LIC_FILES_CHKSUM = "file://${WORKDIR}/arm-gnu-toolchain-13.2.Rel1-x86_64-aarch64-none-elf/license.txt;md5=3a4c8f624bd77882c8dc3beb13171154"

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
