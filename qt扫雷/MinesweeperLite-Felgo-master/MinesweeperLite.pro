CONFIG += felgo
CONFIG += felgo-live


PRODUCT_IDENTIFIER = com.trebledj.MinesweeperLite
PRODUCT_VERSION_NAME = 1.0.0
PRODUCT_VERSION_CODE = 1


PRODUCT_LICENSE_KEY = ""

qmlFolder.source = qml
DEPLOYMENTFOLDERS += qmlFolder

assetsFolder.source = assets
DEPLOYMENTFOLDERS += assetsFolder



RESOURCES += \
    images.qrc

SOURCES += main.cpp


android {
    ANDROID_PACKAGE_SOURCE_DIR = $$PWD/android
    OTHER_FILES += android/AndroidManifest.xml       android/build.gradle
}

ios {
    QMAKE_INFO_PLIST = ios/Project-Info.plist
    OTHER_FILES += $$QMAKE_INFO_PLIST
}

win32 {
    RC_FILE += win/app_icon.rc
}
macx {
    ICON = macx/app_icon.icns
}

DISTFILES += \
    ../../GitHub/MinesweeperLite/qml/MSUtils.js \
    ../../GitHub/MinesweeperLite/qml/MSTarget.js \
    ../../GitHub/MinesweeperLite/qml/MSLogic.js \
    ../../GitHub/MinesweeperLite/qml/MSEnum.js
