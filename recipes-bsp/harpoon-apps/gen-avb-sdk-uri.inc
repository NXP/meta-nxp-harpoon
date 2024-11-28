# Copyright 2022-2023 NXP

LICENSE += "& BSD-3-Clause"
LIC_FILES_CHKSUM += " \
    file://gen_avb_sdk/licenses/BSD-3-Clause;md5=5cc0aa6b0086f08ef02006d8a2679704"

GENAVB_BRANCH = "6_5"

SRC_GEN_AVB_SDK = "git://github.com/NXP/GenAVB_TSN.git;protocol=https;branch=${GENAVB_BRANCH};destsuffix=git/gen_avb_sdk;name=gen-avb-sdk"

SRCREV_gen-avb-sdk = "ca90ec3d63113af532ff7b35bfea575df290a9f8"
