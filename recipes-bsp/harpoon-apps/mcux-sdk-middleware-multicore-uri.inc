# Copyright 2022, 2025 NXP

SRC_URI += "\
    git://github.com/nxp-mcuxpresso/mcux-sdk-middleware-multicore.git;protocol=https;nobranch=1;destsuffix=git/middleware/multicore;name=mcux-sdk-middleware-multicore \
"

SRCREV_FORMAT:append = "_mcux-sdk-middleware-multicore"
SRCREV_mcux-sdk-middleware-multicore = "5b8772984399c3fa4c1bc3d530db09fef74349c7"
