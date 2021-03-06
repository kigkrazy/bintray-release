package com.novoda.gradle.test

class GradleScriptTemplates {

    static String forJavaProject() {
        return """
            plugins { 
                id 'java-library'
                id 'com.novoda.bintray-release'
            }
            
            repositories {
                jcenter()
            }
            
            dependencies {
                implementation "junit:junit:4.12"
            }
            
            publish {
                userOrg = 'novoda'
                groupId = 'com.novoda'
                artifactId = 'test'
                publishVersion = '1.0'
                desc = 'description'
            }
               """.stripIndent()
    }

    static String forAndroidProject(String androidGradlePluginVersion = '3.0.0') {
        return """
            buildscript {
                repositories {
                    google()
                    jcenter()
                }
                dependencies {
                    classpath 'com.android.tools.build:gradle:$androidGradlePluginVersion'
                }
            }
            
            plugins {
                id 'com.novoda.bintray-release'
            }
            
            apply plugin: "com.android.library"
            
            android {
                compileSdkVersion 26
                buildToolsVersion "26.0.2"

                defaultConfig {
                    minSdkVersion 16
                    versionCode 1
                    versionName "0.0.1"
                }    
                
                lintOptions {
                   tasks.lint.enabled = false
                }
            }
            
            repositories {
                google()
                jcenter()
            }
            
            publish {
                userOrg = 'novoda'
                groupId = 'com.novoda'
                artifactId = 'test'
                publishVersion = '1.0'
                desc = 'description'
            }
               """.stripIndent()
    }
}
