/* TEST
*/
int trico;

void test(char hola) {
  return;
}
int x[3] = {3, 2};
int y[3][4] = {{0, 1, 2, 3}, {4, 5, 6, 7}, {8, 9, 10, 11},};
int z[3][4][2] =
{
    {
        { 13, 3 },
        { 47, 48 },
        { 35, 84 },
        { 85, 36 }
    },
    {
        { 71, 16 },
        { 73, 34 },
        { 95, 23 },
        { 70, 93 }
    },
    {
        { 98, 19 },
        { 77, 32 },
        { 6, 10 },
        { 50, 11 },
    }
};

char main(int argc, int argd){
  char w[3] = {'d'};
  char y = '1' + w[2];
  int i, b, c = 5 + 5;
  int d[3] = {3, 3, 5};

  trico++;
  for (i = 0; i < 3; i++) {

    for (b = 0; b < 3; b++) {
      c = 13;
       d[0] = 5;
      if (b == 0) {
        return '1';
      }
      if (b) {
        return '0';
      }
      continue;
    }
  }

  ++z[2][3][1];
  return w[0];
}