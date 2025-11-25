# Copyright 2022-2023, 2025 NXP

require heterogeneous-multicore.inc

LICENSE += "& BSD-3-Clause"
LIC_FILES_CHKSUM += " \
    file://rpmsg-lite/LICENSE;md5=b66f32a90f9577a5a3255c21d79bc619"

SRC_URI += "\
    git://github.com/nxp-mcuxpresso/rpmsg-lite.git;protocol=https;nobranch=1;destsuffix=git/rpmsg-lite;name=rpmsg-lite \
"

SRCREV_FORMAT:append = "_rpmsg-lite"
SRCREV_rpmsg-lite = "42a37572d84fbabb35455292b3a87244b10a877e"
