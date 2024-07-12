# Copyright 2022 NXP

SRC_URI += "\
    git://github.com/nxp-mcuxpresso/mcux-sdk-middleware-multicore.git;protocol=https;nobranch=1;destsuffix=git/middleware/multicore;name=mcux-sdk-middleware-multicore \
"

SRCREV_FORMAT:append = "_mcux-sdk-middleware-multicore"
SRCREV_mcux-sdk-middleware-multicore = "7ae65fe481b70093d71c4ffd7e2f9f1427717035"
