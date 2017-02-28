from org.springframework.scripting.support import ResourceScriptSource
rScript = ResourceScriptSource()
#This is a script content
scriptContent = rScript.getScriptAsString()
ret = '脚本：%s\n ' % (scriptContent)
print ret