func myAtoi(s string) int {
    
    s = strings.Trim(s, " ");
        
    sign := 1
    num  := int64(0)

    sLen := len(s)
    for i := 0; i < sLen; i++ {
        currentSymbol := s[i]

        if i == 0 && (currentSymbol == '+' || currentSymbol == '-') {
            if currentSymbol == '-' {
                sign = -1
            }
            continue;
        }

        if currentSymbol >= '0' && currentSymbol <= '9' {
            num = num * 10 + int64(currentSymbol - '0')

            if num * int64(sign) > math.MaxInt32 {
                return math.MaxInt32
            }
            if num * int64(sign) < math.MinInt32 {
                return math.MinInt32
            }

        } else {
            return int(num) * sign;
        }
    }


    return int(num) * sign;
    
}