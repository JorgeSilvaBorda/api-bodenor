## $1="192.168.102.181"
## $2="2"
## $3="1"



TIMESTAMP="TIMESTAMP["$(date +"%Y-%m-%d %H:%M:%S")"]"
IP="IP[$1]"
EQUIPO="EQUIPO[$2]"
IDREM="IDREM[$3]"

CONTENIDO=$(./modpoll -m enc -t4 -a $3 -r 49 -c 50 -1 -o 1 $1 -p 1024)


curl -X POST -H "Content-Type: text/plain" -d "$TIMESTAMP$IP$EQUIPO$IDREM$CONTENIDO" http://localhost:8080/lectura/circutorcvmC10
