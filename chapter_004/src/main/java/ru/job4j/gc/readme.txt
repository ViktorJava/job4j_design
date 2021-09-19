Для работы проекта tracker я выбрал SerialGC. Руководствовался я теми соображениями, что он менее эффективный к экстримальным нагрузкам в ограниченных условиях.
Сконфигурировал я VM следующим образом:
-XX:+UseSerialGC
-Xmx3m
-XX:SurvivorRatio=1
-XX:NewRatio=1
-XX:MaxMetaspaceSize=9m
-Xlog:gc
-Xlog:gc*:file=C:\Users\Viktor\Desktop\tracker\log.log:time

jhsdb jmap --heap --pid 11492
В результате получил следующее распределение памяти:
Old space: 2Mb
S0 и S1: 640Kb
Eden space: 768Kb
Metaspace: 9Mb
