# Copyright 2021-2022, 2024-2025 NXP

SUMMARY = "ARM toolchain"
SECTION = "devel"
LICENSE = "GPL-3.0-with-GCC-exception & GPL-3.0-only"

TC_NAME = "arm-gnu-toolchain-${PV}-x86_64-aarch64-none-elf"

LIC_FILES_CHKSUM = "file://${UNPACKDIR}/arm-gnu-toolchain-${PV}-x86_64-aarch64-none-elf/license.txt;md5=3a4c8f624bd77882c8dc3beb13171154"

SRC_URI = "https://developer.arm.com/-/media/Files/downloads/gnu/${PV}/binrel/${TC_NAME}.tar.xz"

SRC_URI[md5sum] = "b461c045a1e3faa147f6f63c578e1fef"

do_configure[noexec] = "1"
do_compile[noexec] = "1"

do_install () {
	install -d ${D}${bindir}
	install -d ${D}${bindir}/${PN}-${PV}

	cp -R --no-dereference --preserve=mode,links -v ${UNPACKDIR}/${TC_NAME}/* ${D}${bindir}/${PN}-${PV}/
}

BBCLASSEXTEND =+ "native nativesdk"
INHIBIT_SYSROOT_STRIP = "1"
