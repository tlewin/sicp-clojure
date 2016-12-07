;; First, lets prove, by induction, that fib(n) = (phi^n - psi^n)/sqrt(5)

;; Base case:
;;
;; fib(2) = fib(1) + fib(0)
;; = (((1 + sqrt(5)) / 2)^2 - ((1 - sqrt(5)) / 2)^2)/sqrt(5)
;; Doing some math ...
;; = 1
;;
;; Inductive step:
;;
;; fib(n + 1) = fib(n) + fib(n - 1)
;; = (phi^n - psi^n) / sqrt(5) + (phi^(n + 1) - psi^(n + 1)) / sqrt(5)
;; = ((phi^(n - 1))*(phi + 1) - (psi^(n - 1))*(psi + 1)) / sqrt(5)
;;
;; Now, here is the trick:
;; (phi + 1) = ((1 + sqrt(5)) / 2) + 1 = ((sqrt(5) + 3) / 2) = phi^2
;; (psi + 1) = ((1 - sqrt(5)) / 2) + 1 = ((3 - sqrt(5)) / 2) = psi^2
;;
;; Returning to our equation, we have:
;; = ((phi^(n - 1))*(phi^2) - (psi^(n - 1))*(psi^2)) / sqrt(5)
;; = (phi^(n + 1) - psi^(n + 1)) / sqrt(5)
;; = fib(n + 1); QED

;; Now, having the result above, it is easy to see that:
;; |(psi^n)/sqrt(5)| < 0.5, for n >= 0, thus
;; -0.5 < fib(n) - (phi^n)/sqrt(5) = -(psi^n)/sqrt(5) < 0.5, for n >= 0
