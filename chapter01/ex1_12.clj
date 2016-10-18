(require '[clojure.string :as string])

;; Recursive implementation
(defn pascal-triangle-elem
  [row column]
  (cond (or (> column row) (< row 0)) 0
        (or (= column 0) (= column row)) 1
        :else (+ (pascal-triangle-elem (- row 1) (- column 1))
                 (pascal-triangle-elem (- row 1) column))))

;; The following functions is only to support Pascal`s triangle print

(defn pascal-triangle-row
  [row]
  (for [c (range (+ row 1))]
    (pascal-triangle-elem row c)))

(defn pascal-triangle
  [rows]
  (for [r (range rows)]
    (pascal-triangle-row r)))

(defn print-centered
  [s size]
  (let [s-length (count s)
        padding-left (/ (- size s-length) 2)
        padding-right (- size (+ s-length padding-left))]
    (println (string/join (repeat padding-left " "))
             s
             (string/join (repeat padding-right " ")))))

(defn print-pascal-triangle
  [rows]
  (let [triangle (pascal-triangle rows)
        str-rows (map (partial string/join " ") triangle)
        last-row-size (count (last str-rows))]
    (doseq [row str-rows]
      (print-centered row last-row-size))))

(print-pascal-triangle 10)
;              1
;             1 1
;            1 2 1
;           1 3 3 1
;          1 4 6 4 1
;        1 5 10 10 5 1
;      1 6 15 20 15 6 1
;     1 7 21 35 35 21 7 1
;   1 8 28 56 70 56 28 8 1
; 1 9 36 84 126 126 84 36 9 1
