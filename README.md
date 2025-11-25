i.MX Linux Yocto Project BSP 6.12.34-2.1.0 Harpoon v3 Release
=============================================================

The following boards were tested in this release:

   * NXP i.MX 8M Mini LPDDR4 EVK (imx8mm-lpddr4-evk)
   * NXP i.MX 8M Nano LPDDR4 EVK (imx8mn-lpddr4-evk)
   * NXP i.MX 8M Plus LPDDR4 EVK (imx8mp-lpddr4-evk)
   * NXP i.MX 93 LPDDR4 EVK (imx93evk)
   * NXP i.MX 943 EVK (imx943evk)
   * NXP i.MX 95 15x15 LPDDR4x EVK (imx95-15x15-lpddr4x-evk)
   * NXP i.MX 95 19x19 LPDDR5 EVK (imx95-19x19-lpddr5-evk)

Quick Start Guide
-----------------
See the i.MX Yocto Project User's Guide for instructions on installing repo.

First install the i.MX Linux BSP repo:
```
$ repo init -u https://github.com/nxp-imx/imx-manifest -b imx-linux-walnascar -m imx-6.12.34-2.1.0_harpoon-v3.xml
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
