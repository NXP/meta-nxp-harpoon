# Copyright 2022 NXP

require mcux-sdk-middleware-multicore-uri.inc

RPMSG_LITE_BRANCH = "feature/heterogeneous_multicore"

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = " \
    file://middleware/multicore/rpmsg_lite/LICENSE;md5=c0fed0bf9e1deb5c641019b94eeb8bde"

SRC_URI += "\
    git://github.com/NXPmicro/rpmsg-lite.git;protocol=https;branch=${RPMSG_LITE_BRANCH};destsuffix=git/middleware/multicore/rpmsg_lite;name=rpmsg-lite \
"

SRCREV_FORMAT:append = "_rpmsg-lite"
SRCREV_rpmsg-lite = "79e75052def3a2200106b02334bd13227382bbe6"
