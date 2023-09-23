# NBT

A NBT lib with r/w support

## Installation

NBT is available on Maven from either the [Official Maven Repository](https://repo.bb1.fun/#/releases/com/tubmc/nbt) or [JitPack](https://jitpack.io/#TubMC/NBT)

### Official Repository

The latest version is hosted on an [Official Maven Repository](https://repo.bb1.fun/#/releases/com/tubmc/NBT)

First include the repository:

```xml
<repository>
  <id>bb1-repository-releases</id>
  <name>BradBot_1's Repository</name>
  <url>https://repo.bb1.fun/releases</url>
</repository>
```

Then add the dependency:

```xml
<dependency>
  <groupId>com.tubmc</groupId>
  <artifactId>nbt</artifactId>
  <version>1.0.2</version>
</dependency>
```

### Jitpack

If the official repository is down or you choose not to trust it you can always pull it from [JitPack](https://jitpack.io/#TubMC/NBT)

First include the repository:

```xml
<repository>
  <id>jitpack.io</id>
  <url>https://jitpack.io</url>
</repository>
```

Then add the dependency:

```xml
<dependency>
  <groupId>com.github.TubMC</groupId>
  <artifactId>NBT</artifactId>
  <version>-SNAPSHOT</version>
</dependency>
```

### Local Installation

Just run the following commands:

```shell
git clone https://github.com/TubMC/NBT.git
cd TextComponents
mvn clean install
```

It will then be accessible from your [local Maven Repoistory](https://www.javatpoint.com/maven-repository)

Now you can simply add the following dependency without a repository:

```xml
<dependency>
  <groupId>com.tubmc</groupId>
  <artifactId>nbt</artifactId>
  <version>1.0.2</version>
</dependency>
```
