  # Binary to Decimal.
  # Decimal to Binary.
  # 1's & 2's Complement.


  # Operators.
   # And -> All 1 = 1; 1 zero = 0; &
   # Or  -> All 0 = 0; 1 one = 1;  |
   # Not -> Flip all the bits;  ~
   # XOR -> same = 0 , different = 1; ^
   # Shift => Right & Left; >> , <<
   # Right -> removes the last bit and add it from initial value; n = value / 2^k; [ value = 13, k = 1]
   # Left ->  add zero to the last bit; n = value * 2^k; [ value = 13, k = 1]

   #  13 & 7  ==> 1101 & 0111 --> 0101 --> 5;
   #  13 | 7  ==> 1101 | 0111 --> 1111 --> 15;
   # ~(5) ==> ~ 0101 --> 1010 + 0001 --> 1011[11];
   #  13 ^ 7  ==> 1101 ^ 0111 --> 1010 --> 10;
   #  13 >> 1 ==> 1101 >> 1 --> 1100 --> 6;
   #  13 << 1 ==> 1101 << 1 --> 11010 --> 26;

   ## INT_MAX = 2^31 - 1;[0 .......1101]
   ## INT_MIN = -2^31;[1 .......1101]

   # If the given value is negative then the computer store it's 2's complement.
   # There are 32 bits[4 byte] for Integer and Always 31 st bit is for sign.

