from re import U
import urllib.request
from bs4 import BeautifulSoup

def remetre(frase):
    changed = frase.replace(":",".")
    return changed

def main():
    mot = ["sortir","danser","rester","partir","parler"]
    i = 0
    while i < len(mot):
        url_larousse = ('https://www.larousse.fr/dictionnaires/francais/'+mot[i])
        page = urllib.request.urlopen(url_larousse)
        soup = BeautifulSoup(page, 'html5lib')
        

        if soup.find('span', class_='numDef') is not None:
            for decomp in soup.select('span', class_='numDef'):
                decomp.decompose()

        if soup.find('span', class_='ExempleDefinition') is not None:
            for decomp in soup.select('ExempleDefinition'):
                decomp.decompose()
        if soup.find('p',class_='LibelleSynonyme') is not None:
            for decomp in soup.select('p.LibelleSynonyme'): 
                decomp.decompose()
        if soup.find('p',class_='Synonymes') is not None:
            for decomp in soup.select('p.Synonymes'):
                decomp.decompose()
        
        tag_li = soup.find('li', class_='DivisionDefinition')
        txt_tag_li = tag_li.text.strip()
        
        changed_frase = remetre(txt_tag_li)

        print(mot[i] + ";" +changed_frase)
        i += 1

main()