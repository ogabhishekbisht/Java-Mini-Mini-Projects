#include<stdio.h>
#include<conio.h>
void main()
{
	int ieeecount = 0;
	int expo = 0;
	int expoarray[8];
	int decicount = 0;
	int floatarray[64];
	int count = 0;
	int ieee[64];
	int temparray[64];
	int deciarray[64];
	float value;
	int decivalue;
	float floatvalue;
	int temp;
	int ncount = 0;
	int i,j;
	clrscr();
	for(i = 0; i < 64; i++)
		ieee[i] = 0;
	printf("\n\nEnter the decimal number to be converted to IEEE 754 format = ");
	scanf("%f", &value);
	printf("\nEntered Value = %f", value);
	if(value < 0)
	{
		ieee[0] = 1;
		value = value * -1;
	}
	printf("\nMagnitude of Value = %f", value);
	decivalue = (int)value;
	floatvalue = value - decivalue;
	printf("\nDecimal Value = %d", decivalue);
	printf("\nFloating Value = %f", floatvalue);
	temp = decivalue;
	while(temp != 0)
	{
	count++;
	temparray[i] = temp%2;
	temp = temp /2;
	i++;
	}
	i--;
	j = 0;
	while(i >= 0)
	{
	deciarray[j] = temparray[i];
	j++;
	i--;
	}
	printf("\n\nBinary Equivalent of Decimal Value = ");
	for(i = 0; i < count; i++, decicount++)
		printf("%d", deciarray[i]);
	printf("\nDeci Count = %d", decicount);
	printf("\n\nBinary Equivalent of Floating Value = ");
	for(i = 0; i < 23; i++ )
	{
	floatvalue = floatvalue * 2;
	if(floatvalue > 1)
	{
	floatarray[i] = 1;
	floatvalue = floatvalue - (int)floatvalue;
	}
	else
	floatarray[i] = 0;
	}
	for(i = 0; i < 23; i++)
	printf("%d", floatarray[i]);
	printf("\n\n**BINARY EQUIVALENT OF THE NUMBER**\n");
	for(i = 0; i < count; i++)
		printf("%d", deciarray[i]);
	printf(".");
	for(i = 0; i < 23; i++)
	printf("%d", floatarray[i]);
	i = -1;
	do
	{
		ncount++;
		i++;
	}while(deciarray[i] != 1);
	printf("\nNo of bits to be shifted for normalization = %d", (decicount-ncount) );
	expo = decicount-ncount;
	printf("\nExponent Value = %d", expo);
	expo = 127+expo;
	printf("\nBiased Exponent Value = %d", expo);
	temp = expo;
	while(temp != 0)
	{
	count++;
	temparray[i] = temp%2;
	temp = temp /2;
	i++;
	}
	i--;
	j = 0;
	while(i >= 0)
	{
	expoarray[j] = temparray[i];
	j++;
	i--;
	}
	printf("\nBinary Conversion of exponent value = ");
	for(i = 0; i < 8; i++)
		printf("%d",expoarray[i]);
	ieeecount = 1;
	i = 0;
	while(i < 8)
		ieee[ieeecount++] = expoarray[i++];
	i = 1;
	while( i <= (decicount-ncount))
		ieee[ieeecount++] = deciarray[i++];
	i = 0;
	while(i < 23)
		ieee[ieeecount++] = floatarray[i++];
	i = 0 ;
	printf("\n\n Ultimate Answer = \n");
	while(i < 32)
		printf( "%d", ieee[i++]);
	getch();
}
	