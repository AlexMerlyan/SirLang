# Сударь - это простейший язык программирования для начинающих. Моей целью является максимально низкий порог вхождения для новичков.
# Инструкцию по запуску вы можете найти ниже:
1. Скачайте или клонируйте этот проект
2. Запустите команду в командной строке: mvn clean compile assembly:single
3. В папке вашего проекта должен появиться  SirLang-1.0-SNAPSHOT-jar-with-dependencies.jar в папке target
4. Переместите hello_world.sir файл в папку target
5. Откройте командную строку из папки target
6. Введите команду java -cp %jar_file.jar% %packageOne.package2.ClassName% %dir1/dir/file.sir2% и нажмите Enter

# SirLang - is simple programming language for juniors
# Instructions for install and using:
1. Clone or download this project (install maven, jdk, java home variable)
2. Run command:  mvn clean compile assembly:single
3. In your project should appear SirLang-1.0-SNAPSHOT-jar-with-dependencies.jar in directory target
4. Move hello_world.sir file to directory of this jar.
5. Open terminal from directory of this jar.
6. Run command: java -cp %jar_file.jar% %packageOne.package2.ClassName% %dir1/dir/file.sir2%

Example: java -cp SirLang-1.0-SNAPSHOT-jar-with-dependencies.jar com.sirlang.Main /home/user/IdeaProjects/SirLang/target/file.sir

PROFIT!

Maven config:

<repository>
    <id>SirLang-mvn-repo</id>
    <url>https://raw.github.com/AlexMerlyan/SirLang/mvn-repo/</url>
    <snapshots>
        <enabled>true</enabled>
        <updatePolicy>always</updatePolicy>
    </snapshots>
</repository>

<dependency>
    <groupId>SirLang</groupId>
    <artifactId>SirLang</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>


P.S.: If you wanna try work with it you can try https://calm-lake-11769.herokuapp.com/
Try to send post request https://calm-lake-11769.herokuapp.com/compile
with body:
{
	"sirlangCode": "Приветствую!\nСударь, будьте добры, выведите на экран это: \"Моя первая программа на языке Сударь!\"\nСпасибо вам! Всего хорошего!"
}
