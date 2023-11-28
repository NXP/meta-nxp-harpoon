# Copyright 2022-2023 NXP

require mcux-sdk-middleware-multicore-uri.inc
require heterogeneous-multicore.inc

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = " \
    file://middleware/multicore/rpmsg_lite/LICENSE;md5=8362f2b955bc8da49b21f6a7b81e49cf"

SRC_URI += "\
    git://github.com/nxp-mcuxpresso/rpmsg-lite.git;protocol=https;nobranch=1;destsuffix=git/middleware/multicore/rpmsg_lite;name=rpmsg-lite \
"

SRCREV_FORMAT:append = "_rpmsg-lite"
SRCREV_rpmsg-lite = "c416810ac097381c2755fb793a8a1567f2bd3d4a"
