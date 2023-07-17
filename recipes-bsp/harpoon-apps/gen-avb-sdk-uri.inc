# Copyright (C) 2022-2023 NXP

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = " \
    file://gen_avb_sdk/licenses/BSD-3-Clause;md5=5cc0aa6b0086f08ef02006d8a2679704"

GENAVB_BRANCH="5_7"

SRC_GEN_AVB_SDK = "git://github.com/NXP/GenAVB_TSN.git;protocol=https;branch=${GENAVB_BRANCH};destsuffix=git/gen_avb_sdk;name=gen-avb-sdk"

SRCREV_gen-avb-sdk = "6aa2f518cd39425719c7374676e376d08c9d0358"
SRCREV_FORMAT:append = "_gen-avb-sdk"
