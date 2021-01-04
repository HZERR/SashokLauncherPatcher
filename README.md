# SashokLauncherPatcher
Patcher of launchers that are based on the Sashok274 launcher.


## WARNING!!! Работает только под Windows!!!

### Начало:
1. Необходимо создать пустую папку, в которой будет происходить вся "магия"
2. Скопировать в созданную папку jar-файл проекта, который необходимо пропатчить
3. Открыть gradle.properties и поменять пути folder.full.name и project.full.name, а также изменить тестовое название jar-файла (project.test.name)
4. Изменить названия классов на те, которые соответствуют взламываемому jar-файлу

### Патчинг
1. Запустить в build.gradle Unpack task
2. Запустить ChangeManifest task
3. Запустить Transform task
4. Запустить Build task (см. вывод в консоль!)
5. Если какие-то папки не были добавлены в jar-файл, то 
    * Запускаем UpdateProject task
6. Запустить Start task

<b> Готово </b>

### Util-классы
1. Unpack - распаковывает jar-файл
2. ManifestChanger - модифицирует папку META-INF. Перед использованием необходимо распаковать проект
3. Transformator - изменяет байт-код классов. Перед использованием желательно распаковать проект
4. Builder - собирает проект. Перед использованием необходимо распаковать проект
5. ProjectUpdater - обновляет файлы, которые не попали в проект при его сборке. Перед использованием необходимо распаковать и собрать проект
6. Starter - запускает собранный jar-файл. Перед использованием необходимо собрать проект
7. Cleaner - очищает все содержимое папки кроме оригинального jar-файла
8. Cleaner.TestProjectCleaner - удаляет построенный jar-файл
9. JFoenixAppender - добавляет в собранный jar-файл библиотеку JFoenix-8.0.10. Перед использованием необходимо собрать проект

### Tasks

| Name                             | Group               | Description                                                                               |
| -------------------------------- | ------------------- | ----------------------------------------------------------------------------------------- |
| Start                            | modifications       | Launches the assembled jar file                                                           |
| Unpack                           | modifications       | Unpack the original jar file                                                              |
| Build                            | modifications       | Assembles the project                                                                     |
| Transform                        | modifications       | Changes the bytecode of the classes                                                       |
| ChangeManifest                   | modifications       | Modifies the META-INF folder                                                              |
| UpdateProject                    | modifications       | Updates the specified folders/files                                                       |
| UpdateLauncherFolder             | modifications       | Updates the contents of the 'launcher' folder in the assembled jar file                   |
| UpdateRuntimeFolder              | modifications       | Updates the contents of the 'runtime' folder in the built jar file                        |
| Clean                            | modifications       | Clears all the contents of the folder except the original jar file                        |
| CleanTestProject                 | modifications       | Deletes the built jar file                                                                |
| AddJFoenixLibrary                | modifications       | Adds the JFoenix-8.0.10 library to the assembled jar file                                 |
| UpdateRuntimeFolderAndRun        | group modifications | Starts tasks UpdateRuntimeFolder and Start one by one                                     |
| UpdateLauncherFolderAndRun       | group modifications | Starts tasks UpdateLauncherFolder and Start one by one                                    |
| UnpackChangeAllBuildUpdateAndRun | group modifications | Starts tasks Unpack, Transform, ChangeManifest, Build, UpdateProject and Start one by one |
| Rebuild                          | group modifications | Starts tasks CleanTestProject, Build, UpdateProject and Start one by one                  |
