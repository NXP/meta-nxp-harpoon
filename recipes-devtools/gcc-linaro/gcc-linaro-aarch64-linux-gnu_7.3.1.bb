#
# This file was derived from the 'Hello World!' example recipe in the
# Yocto Project Development Manual.
#

require recipes-devtools/gcc-linaro/gcc-linaro.inc

TC_NAME = "gcc-linaro-7.3.1-2018.05-x86_64_aarch64-linux-gnu"

SRC_URI = "https://releases.linaro.org/components/toolchain/binaries/7.3-2018.05/aarch64-linux-gnu/${TC_NAME}.tar.xz"

SRC_URI[md5sum] = "6ec789d642584a01e240ab3366599dbb"

