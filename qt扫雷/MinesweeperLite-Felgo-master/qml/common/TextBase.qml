//	TextBase.qml

import QtQuick 2.0

Text {
	id: textBase
	
	property bool animate: false
	property bool firmAnchor: false
	
    //配色为“淡金黄色”，“海军蓝”，“黄色”
	color: "navy"
	
	text: ""
    font.family: "Consolas"
//	font.family: trebuchetMs.name
	
//	FontLoader { id: trebuchetMs; source: "qrc:/assets/TrebuchetMS.ttf" }
}
