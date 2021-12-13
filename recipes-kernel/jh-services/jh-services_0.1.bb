SUMMARY = "Jailhouse external Linux kernel modules"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=59530bdf33659b29e73d4adb9f9f6552"

S = "${WORKDIR}/git"

JH_SERVICES_SRC = "git://github.com/NXPmicro/jh-services.git;protocol=https;"
SRC_URI = "${JH_SERVICES_SRC};branch=${SRCBRANCH}"
SRCREV = "47d433dfdd4c691e9d548f05b1b56c886350eb20"
SRCBRANCH = "main"

inherit module

EXTRA_OEMAKE_append = " KDIR=${STAGING_KERNEL_DIR} V=1"

do_install_append_releasepkg() {
	# Files needed for release packages
	mkdir -p ${DEPLOY_DIR_IMAGE}/release_package
	cp ${S}/*.ko ${DEPLOY_DIR_IMAGE}/release_package
}
