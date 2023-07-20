# Copyright 2022-2023 NXP

SRC_URI += "\
    git://github.com/nxp-mcuxpresso/mcux-sdk-middleware-multicore.git;protocol=https;nobranch=1;destsuffix=git/middleware/multicore;name=mcux-sdk-middleware-multicore \
"

SRCREV_FORMAT:append = "_mcux-sdk-middleware-multicore"
SRCREV_mcux-sdk-middleware-multicore = "e914909af2bf44fd651e3383ba0cd8cf5f0bda66"
