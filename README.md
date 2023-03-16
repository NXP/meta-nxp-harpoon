i.MX Linux Yocto Project BSP 6.1.1-1.0.0 Harpoon v2 Release
=============================================================

The following boards were tested in this release:

   * NXP i.MX 8MMini LPDDR4 EVK (imx8mm-lpddr4-evk)
   * NXP i.MX 8MNano LPDDR4 EVK (imx8mn-lpddr4-evk)
   * NXP i.MX 8MPlus LPDDR4 EVK (imx8mp-lpddr4-evk)
   * NXP i.MX 93 LPDDR4 EVK (imx93evk)

Quick Start Guide
-----------------
See the i.MX Yocto Project User's Guide for instructions on installing repo.

First install the i.MX Linux BSP repo:
```
$ repo init -u https://github.com/nxp-imx/imx-manifest -b imx-linux-langdale -m imx-6.1.1-1.0.0_harpoon-v2.xml
```

Download the Yocto Project Layers:
```
$ repo sync
```

Run i.MX Linux Project Setup:
```
$ [MACHINE=<machine>] [DISTRO=fsl-imx-<backend>] source ./imx-harpoon-setup-release.sh -b <build folder>
```

After this your system will be configured to start a Yocto Project build.

Build images
------------
Build the default i.MX image:

```
$ bitbake imx-image-core
```
