# Copyright 2022-2023 NXP
# Released under the MIT license (see COPYING.MIT for the terms)

SUMMARY = "NXP Harpoon package group"
DESCRIPTION = "Contains the packages needed by Harpoon."
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"
PACKAGES = "${PN}"

harpoon-pkgs ?= ""
harpoon-pkgs:imx8mm-lpddr4-evk = "harpoon-apps-ctrl harpoon-apps-ctrl-rpmsg harpoon-apps-freertos-audio harpoon-apps-freertos-hello-world harpoon-apps-freertos-industrial harpoon-apps-freertos-rt-latency harpoon-apps-zephyr-audio harpoon-apps-zephyr-audio-smp harpoon-apps-zephyr-hello-world harpoon-apps-zephyr-industrial harpoon-apps-zephyr-rt-latency"
harpoon-pkgs:imx8mn-lpddr4-evk = "harpoon-apps-ctrl harpoon-apps-ctrl-rpmsg harpoon-apps-freertos-audio harpoon-apps-freertos-hello-world harpoon-apps-freertos-industrial harpoon-apps-freertos-rt-latency harpoon-apps-zephyr-audio harpoon-apps-zephyr-audio-smp harpoon-apps-zephyr-hello-world harpoon-apps-zephyr-industrial harpoon-apps-zephyr-rt-latency"
harpoon-pkgs:imx8mp-lpddr4-evk = "harpoon-apps-ctrl harpoon-apps-ctrl-rpmsg harpoon-apps-freertos-audio harpoon-apps-freertos-hello-world harpoon-apps-freertos-industrial harpoon-apps-freertos-rt-latency harpoon-apps-zephyr-audio harpoon-apps-zephyr-audio-smp harpoon-apps-zephyr-hello-world harpoon-apps-zephyr-industrial harpoon-apps-zephyr-rt-latency"
harpoon-pkgs:imx93evk = "harpoon-apps-ctrl harpoon-apps-freertos-hello-world harpoon-apps-zephyr-hello-world"

RDEPENDS:${PN} = " \
    ${harpoon-pkgs} \
"
