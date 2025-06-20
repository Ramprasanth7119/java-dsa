** In order to perform binary Search, the array should be sorted. **

1) Real time examples --> Dictionary.

2) Overflow case
    -- If the array has a size of INT_MAX, then possibly at a worst case, the mid would be 
            mid = (INT_MAX + INT_MAX) / 2.
            ** This will leads to a overflow condition, To avoid this, 
                    ==> mid = low + (high - low) / 2
                    Which is comes from --> mid = ((2 * low) + high - low) / 2;

                    