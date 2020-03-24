public class Oppgave2 {
    public static void main(String[] args) {


        /**
         *
         * Metoden nyMidten er O(n). Hvorfor?
         * metoden itererer gjennom halvparten av n elementer
         * 0.5n
         *
         * vi fjerner konstanter n�r vi finner big O
         *  dermed har metoden O=(n)
         *
         *  om midt m� oppdaters n�r vi legger til eller fjerner.
         *
         *  Om vi legger til i en del  m� midt flyttes en posisjon mot same del
         *  om vi fjerner fra en del m� midt flyttes en posisjon mot motsatt del.
         *
         *  I tilleg trenger vi kun � oppdatere n�r nytt antall er oddetall
         *   og vi trenger ikke � oppdatere om vi endrer til i annene hver del med samme type operasjon
         *   Alts�: N er oddetal. Legg til over mid. n er partall. legg til under min.
         *   n er oddetall men trenger ikke � oppdateres.
         *
         *   eller ved fjerning og legg til p� samme side i annenhver sekvens.
         *
         *
         *  D
         *  i)
         *
         *  gjennomsnitt av linear s�k n�r vi vet det finnest og posijonen er vilk�rlig
         *  er 1/n. hver posisjon er like sannsynlig.
         *  1*1/n+2*1/n+3*1/n+.....n*1/n    / n
         *  (1/n+2/n+3/n+....n*1/n)           / n
         *  (1+2+3+4+5....(n-1)+n)/n
         *    sum = 1+2+3+4+5....(n-1)+n
         *    2sum= (n+1)n
         *          sum= n(n+1)/2               / n
         *      n(n+1)/2 /n
         *          (n+1)/2
         *  gjennomsnitt n+1/2
         *
         *  ; worst n antall
         *
         *
         *  ii) med midt en veis
         *
         *      avrage er halvparten av avrage i i. (linear uten mid
         *      mens worst 0.5n
         *
         *   iii)
         *   avrage er halvparten av avrage i  ii (linear med mid
         *          *      mens worst 0.25n
         *
         */




    }
}
