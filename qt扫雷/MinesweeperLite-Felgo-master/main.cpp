#include <QApplication>
#include <FelgoApplication>

#include <QQmlApplicationEngine>
#include <QQmlContext>


#ifndef PUBLISH
# include <FelgoLiveClient>
#endif

//#include <QDebug>


int main(int argc, char *argv[])
{

    QApplication app(argc, argv);


    FelgoApplication felgo;
    QQmlApplicationEngine engine;
    felgo.initialize(&engine);

#ifndef	PUBLISH
    felgo.setMainQmlFileName(QStringLiteral("qml/Main.qml"));

#endif


#ifdef PUBLISH
    felgo.setMainQmlFileName(QStringLiteral("qrc:/qml/Main.qml"));
#endif

#ifdef PUBLISH
    engine.load(QUrl(felgo.mainQmlFileName()));
#else
    FelgoLiveClient liveClient(&engine);
#endif

    return app.exec();
}
