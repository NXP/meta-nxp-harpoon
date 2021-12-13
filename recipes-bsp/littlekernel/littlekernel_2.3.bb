SUMMARY = "Little Kernel"
SECTION = "bsp"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://lk/LICENSE;md5=25394d472e4c06f4d61140e88861fb5b"

S = "${WORKDIR}/git"

SRC_URI = " \
	git://github.com/NXPmicro/littlekernel-imx8.git;protocol=https;branch=${SRCBRANCH-imx8};destsuffix=git/imx8;name=imx8 \
	git://github.com/NXPmicro/littlekernel-lk.git;protocol=https;branch=${SRCBRANCH-lk};destsuffix=git/lk;name=lk \
"

SRCREV_FORMAT = "imx8_lk"
SRCREV_imx8 = "2568101693df8c96b3ccc18ec659bb5de788d185"
SRCREV_lk = "1b58191008d0f3aa68b93db844b93f32da17c71c"
SRCBRANCH-imx8 = "main"
SRCBRANCH-lk = "main"

SOC_mx8mm = "imx8mm"
SOC_mx8mn = "imx8mn"

COMPATIBLE_MACHINE = "mx8m"

LINARO_TC = "gcc-linaro-aarch64-elf"
LINARO_PV = "7.3.1"
DEPENDS += "${LINARO_TC}-native (= ${LINARO_PV})"
DEPENDS += "dtc-native"
RDEPENDS_${PN} += "bash"
RDEPENDS_${PN} += "dtc"

DTB_NAME = "${SOC}-evk.dtb"
DTB_NAME_HIFIBERRY = "${SOC}-evk-hifiberry-dacplus.dtb"

HARPOON_DATADIR ?= "${datadir}/harpoon"
INMATES_DIR ?= "${HARPOON_DATADIR}/inmates"
SCRIPTS_DIR ?= "${HARPOON_DATADIR}/scripts"

do_compile() {
	unset CFLAGS
	export ARCH_arm64_TOOLCHAIN_PREFIX="${TMPDIR}/sysroots-components/${BUILD_ARCH}/${LINARO_TC}-native/usr/bin/${LINARO_TC}-native-${LINARO_PV}/bin/aarch64-elf-"
	PROJECT=${SOC}-dts make -C ${S}/imx8
}

do_install() {
	install -d ${D}${INMATES_DIR}
	install -d ${D}${SCRIPTS_DIR}

	# Install LittleKernel binary and device trees
	install -m 0644 ${S}/imx8/build-${SOC}-dts/lk.bin ${D}${INMATES_DIR}
	install -m 0644 ${S}/imx8/build-${SOC}-dts/${DTB_NAME} ${D}${INMATES_DIR}
	install -m 0644 ${S}/imx8/build-${SOC}-dts/${DTB_NAME_HIFIBERRY} ${D}${INMATES_DIR}

	# Instantiate jstart script
	sed -e "s/%TEMPLATE_ROOT_CELL%/${JH_ROOT_CELL}/" \
	    -e "s/%TEMPLATE_LK_CELL%/${JH_LK_CELL}/" \
	    -e "s/%TEMPLATE_DTB_BASENAME%/${DTB_NAME}/" \
	    -e "s#%TEMPLATE_BINS_PATH%#${INMATES_DIR}#" \
	    ${S}/imx8/scripts/jstart_lk.sh.template > ${S}/imx8/scripts/jstart_lk.sh

	# Instantiate jstart script
	sed -e "s/%TEMPLATE_ROOT_CELL%/${JH_ROOT_CELL}/" \
	    -e "s/%TEMPLATE_LK_CELL%/${JH_LK_CELL}/" \
	    -e "s/%TEMPLATE_DTB_BASENAME%/${DTB_NAME_HIFIBERRY}/" \
	    -e "s#%TEMPLATE_BINS_PATH%#${INMATES_DIR}#" \
	    ${S}/imx8/scripts/jstart_lk.sh.template > ${S}/imx8/scripts/jstart_lk_hifiberry.sh

	# Install Jailhouse scripts
	install -m 0755 ${S}/imx8/scripts/jstart_lk.sh ${D}${SCRIPTS_DIR}
	install -m 0755 ${S}/imx8/scripts/jstart_lk_hifiberry.sh ${D}${SCRIPTS_DIR}
	install -m 0755 ${S}/imx8/scripts/jkill_lk.sh ${D}${SCRIPTS_DIR}
}

FILES_${PN} += "${HARPOON_DATADIR}"
PACKAGE_ARCH = "${MACHINE_ARCH}"
