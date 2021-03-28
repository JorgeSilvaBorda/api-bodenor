INPUT=/home/jorge/dev/api/bodenor/tabla-circutor.csv
while IFS= read -r line
do
	TIMESTAMP=$(echo $line | cut -d";" -f 1)
	ANIO=$(echo $line | cut -d";" -f 2)
	MES=$(echo $line | cut -d";" -f 3)
	DIA=$(echo $line | cut -d";" -f 4)
	EQUIPO_ID=$(echo $line | cut -d";" -f 5)
	ITEM49=$(echo $line | cut -d";" -f 6)
	ITEM50=$(echo $line | cut -d";" -f 7)
	ITEM95=$(echo $line | cut -d";" -f 8)
	ITEM96=$(echo $line | cut -d";" -f 9)
	
	MENSAJE="TIMESTAMP[$TIMESTAMP]EQUIPO[$EQUIPO_ID][49]: $ITEM49[50]: $ITEM50[95]: $ITEM95[96]: $ITEM96"
	curl -X POST -H "Content-Type: text/plain" -d "$MENSAJE" http://localhost:8080/api/lectura/circutorcvmC10

	
done < $INPUT
