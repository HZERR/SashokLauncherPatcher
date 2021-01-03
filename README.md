# SashokLauncherPatcher
Patcher of launchers that are based on the Sashok274 launcher.


## WARNING!!! Работает только под Windows!!!

### Dependencies
   * commons-io-2.8.0.jar
   * hbcbuilder-v1.0.jar
   * javassist-3.27.0-GA.jar

### Начало:
1. Необходимо создать пустую папку, в которой будет происходить вся "магия"
2. Скопировать в созданную папку jar-файл проекта, который необходимо пропатчить
3. Открыть в IDE класс ru.hzerr.IOHelper и поменять пути FOLDER_FULL_NAME и PROJECT_FULL_NAME, а также изменить тестовое название jar-файла (PROJECT_TEST_NAME)
4. Открыть класс ru.hzerr.Deobfuscator и изменить названия классов на те, которые соответствуют взламываемому jar-файлу

## WARNING!!! Желательно запускать у каждого класса метод main отдельно
### Патчинг
1. Запустить ru.hzerr.util.Unpack.main()
2. Запустить ru.hzerr.util.ManifestChanger.main()
3. Запустить ru.hzerr.util.Tranformator.main()
4. Запустить ru.hzerr.util.Builder.main() (см. вывод в консоль!)
5. Если какие-то папки не были добавлены в jar-файл, то 
    * Открываем ru.hzerr.util.ProjectUpdater
    * Меняем CHANGE_FILE_NAMES (например, CHANGE_FILE_NAMES = "com launcher buildnumber config.bin")
    * Запускаем ru.hzerr.util.ProjectUpdater.main()
6. Запустить ru.hzerr.util.Starter.main()

<b> Готово </b>

### Util-классы
1. Unpack - распаковывает jar-файл
2. ManifestChanger - модифицирует папку META-INF. Перед использованием необходимо распаковать проект
3. Transformator - изменяет байт-код классов. Перед использованием желательно распаковать проект
4. Builder - собирает проект. Перед использованием необходимо распаковать проект
5. ProjectUpdater - обновляет файлы, которые не попали в проект при его сборке. Перед использованием необходимо распаковать и собрать проект
6. ProjectUpdater.LauncherUpdater - обновляет содержимое папки launcher в собранном jar-файле. Перед использованием необходимо распаковать и собрать проект
6. Starter - запускает собранный jar-файл. Перед использованием необходимо собрать проект
7. Cleaner - очищает все содержимое папки кроме оригинального jar-файла
8. Cleaner.TestProjectCleaner - удаляет построенный jar-файл
9. RuntimeReplacer - обновляет содержимое папки runtime в собранном jar-файле. Перед использованием необходимо распаковать и собрать проект
10. JFoenixAppender - добавляет в собранный jar-файл библиотеку JFoenix-8.0.10. Перед использованием необходимо собрать проект
