struct strings
{
char str[20];
};

program STRINGREV_PROG{
version STRINGREV_VERS{
strings stringrev (strings) = 1;
} = 1;
} = 0x31425976;
