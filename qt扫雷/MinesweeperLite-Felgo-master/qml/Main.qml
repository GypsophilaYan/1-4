import Felgo 3.0
import QtQuick 2.12

import "scenes"
import "settings"

GameWindow {
    id: gameWindow


    screenWidth: 640
    screenHeight: 960

    Component.onCompleted: {
        MSSettings.settings = gameWindow.settings;
    }

    MinesweeperScene {
        id: minesweeperScene
    }

    state: "minesweeperScene"
    states: [
        State {
            name: "minesweeperScene"
            PropertyChanges { target: gameWindow; activeScene: minesweeperScene }
            PropertyChanges { target: minesweeperScene; opacity: 1 }
        }
    ]
}
