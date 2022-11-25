# Copyright (C) 2022 NXP

LICENSE = "BSD-3-Clause & Proprietary"
LIC_FILES_CHKSUM = " \
    file://gen_avb_sdk/licenses/EULA.txt;md5=50d7a10985de1383a0894d78e66a3459 \
    file://gen_avb_sdk/licenses/BSD-3-Clause;md5=5cc0aa6b0086f08ef02006d8a2679704"

GENAVB_BRANCH="5_2"

SRC_GEN_AVB_SDK = "git://github.com/NXP/GenAVB_TSN.git;protocol=https;branch=${GENAVB_BRANCH};destsuffix=git/gen_avb_sdk;name=gen-avb-sdk"

SRCREV_FORMAT:append = "_gen-avb-sdk"
SRCREV_gen-avb-sdk = "b5f3515d6a6baf3d9b1763002890582d587588a3"
