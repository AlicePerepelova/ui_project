package config;

import org.aeonbits.owner.Config;

import java.net.URL;

@Config.Sources({
  "classpath:${env}.properties"
})
public interface WebConfig extends Config {

  @Key("browser")
  @DefaultValue("chrome")
  String browser();

  @Key("browserVersion")
  @DefaultValue("100.0")
  String browserVersion();

  @Key("browserSize")
  @DefaultValue("1920x1080")
  String browserSize();

  @Key("baseUrl")
  @DefaultValue("https://sport-marafon.ru/")
  String baseUrl();

  @Key("remoteUrl")
  @DefaultValue("https://user1:1234@selenoid.autotests.cloud/wd/hub")
  URL remoteUrl();

  @Key("isRemote")
  @DefaultValue("false")
  boolean isRemote();
}