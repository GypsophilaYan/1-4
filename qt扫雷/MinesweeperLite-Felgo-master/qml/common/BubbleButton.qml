//  ButtonBase.qml

import QtQuick 2.11

Item {
    id: button

    //信号和属性声明
    // public events
    signal clicked
    signal pressed
    signal released
    signal entered
    signal exited

    property string color
    property string defaultColor: "yellow"
    property string hoverColor: "yellow"
    property alias text: buttonText.text
    property alias textColor: buttonText.color
    property alias horizontalAlignment: buttonText.horizontalAlignment
    property alias verticalAlignment: buttonText.verticalAlignment
    property alias font: buttonText.font
    property alias background: background
    property alias mouseArea: mouseArea

//    属性别名
    property alias image: image

    property bool bubble: true
    property real diagonalScalar: defaultDiagonal

    //这些From-To值将用于动画目的
    property real enteredFrom: bubble ? 0.9 : 1
    property real enteredTo: bubble ? defaultDiagonal : 1

    property real pressedFrom: bubble ? 0.9 : 1
    property real pressedTo: bubble ? 1.05 : 1

    property real releasedFrom: bubble ? pressedTo : 1
    property real releasedTo: bubble ? defaultDiagonal : 1

    //  对角线是冒泡的关键
    property real defaultDiagonal: 1

    property bool isCheckButton: false
    property bool isChecked: false


    //JavaScript函数

    function animateScalar(from, to, duration, type, overshoot) {
        if (scalarAnimation.running)
            return;

        from = (from !== undefined ? from : pressedFrom);
        to = (to !== undefined ? to : pressedTo);
        duration = (duration !== undefined ? duration : 400);
        type = (type !== undefined ? type : Easing.OutBack);
        overshoot = (overshoot!== undefined ? overshoot : 3);

        scalarAnimation.from = from;
        scalarAnimation.to = to;
        scalarAnimation.duration = duration;
        scalarAnimation.easing.type = type;
        scalarAnimation.easing.overshoot = overshoot;

        scalarAnimation.start();
    }

    function animatePress() {
        if (priv.isPressedFlag)
            return;

        priv.isPressedFlag = true;

        if (scalarAnimation.running) {
            scalarAnimation.stop();
            animateScalar(diagonalScalar, pressedTo);
        } else {
            animateScalar(pressedFrom, pressedTo);
        }
    }

    function animateExitPress() {
        // 检查已按下(稍后可能更改)
        if (!priv.isPressedFlag)
            return;

        priv.isPressedFlag = false;    //   关闭按下的标志

        //  check animation is running
        if (scalarAnimation.running) {
            scalarAnimation.stop();    //  停止动画
            animateScalar(diagonalScalar, releasedTo);
        } else {
            animateScalar(releasedFrom, releasedTo);    // 动画显示正常
        }
    }

    function animateOver() {
        animateScalar(enteredFrom, enteredTo);
    }


    // 对象属性和信号处理程序

    state: isChecked ? "on" : "off"

    onColorChanged: defaultColor = hoverColor = color;

    //  animates a bubble
    onPressed: {
        if (!bubble) return;
        animatePress();
    }

    onReleased: {
        if (isCheckButton) isChecked = !isChecked;
        if (!bubble) return;
        animateExitPress();
    }

    onEntered: {
        if (Qt.platform.os === "ios" || Qt.platform.os === "android" || Qt.platform.os === "winrt") return;

        if (!bubble) return;
        animateOver();
    }

    // 私有变量
    QtObject {
        id: priv
        property bool isPressedFlag: false
    }

    // 按钮背景
    Rectangle {
        id: background
        x: -((diagonalScalar - 1) * parent.width / 2); y: -((diagonalScalar - 1) * parent.height / 2)
        width: parent.width * diagonalScalar; height: parent.height * diagonalScalar
        radius: 5
        color: mouseArea.containsMouse ? hoverColor : defaultColor
        opacity: isCheckButton ? isChecked ? 1 : 0.6 : parent.opacity
    }

    //  按钮图片
    Image {
        id: image
        anchors { fill: background; margins: 5 }
        visible: source !== ""
        fillMode: Image.PreserveAspectFit
        mipmap: true
    }

    //  按钮文字
    TextBase {
        id: buttonText
        anchors { fill: firmAnchor ? parent: background; centerIn: background }
        horizontalAlignment: Text.AlignHCenter; verticalAlignment: Text.AlignVCenter
        font.pointSize: 14
    }

    //鼠标区域处理点击事件
    MouseArea {
        id: mouseArea
        anchors.fill: background
        hoverEnabled: true

        onPressed: button.pressed()
        onReleased: button.released()
        onClicked: button.clicked()
        onEntered: button.entered()
        onExited: button.exited()

        onContainsPressChanged: {
            if (!bubble) return;
            if (!containsPress) animateExitPress();
        }
    }

    NumberAnimation on diagonalScalar { id: scalarAnimation }

}
